package com.joson.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.joson.domain.Product;

/*
 * ��ƷDao�ӿ���
 */
@Repository
public interface ProductDao {
	@Results(id ="productMap",value = {
			@Result(id = true,column="product_id",property = "productId"),
			@Result(column="product_name",property = "productName"),
			@Result(column="product_oid",property = "productOid"),
			@Result(column="product_price",property = "productPrice"),
			@Result(column="product_sum",property = "productSum"),
			@Result(column="product_type",property = "productType"),
			@Result(column="product_status",property = "productStatus"),
	})
	
	/*
	 *  ��ѯ���е���Ʒ
	 */
	@Select("select * from item_product")
	List<Product> findAllProducts();
	
	/*
	 * ����Ʒ�������һ����Ʒ
	 */
	@ResultMap("productMap")
	@Insert("insert into item_product(product_name,product_oid,product_price,product_sum,product_type,product_status)"
	                        + "values(#{productName},#{productOid},#{productPrice},#{productSum},#{productType},#{productStatus})")
	void addProduct(Product product);
	
	/*
	 * ������Ʒ������
	 */
	@ResultMap("productMap")
	@Update("update item_product set product_name = #{productName} where product_id=#{productId}")
	void updateProduct(Product product);
	
	/*
	 * ��������ɾ����Ʒ
	 */
	@ResultMap("productMap")
	@Delete("delete from item_product where product_id = #{productId}")
	void deleteProduct(Integer proId);
	
	/*
	 * ɾ��������Ϊoid��ȫ����Ʒ
	 */
	@ResultMap("productMap")
	@Delete("delete from item_product where product_oid=#{productOid}")
	void deleteProducts(Integer prooId);
	
	/*
	 * �������Ʋ鵽�û�
	 */
	@ResultMap("productMap")
	@Select("select * from item_product where product_oid = #{productOid} and product_name = #{productName}")
	Product findByName(@Param("productOid")Integer productOid,@Param("productName")String proName);
	
	
}
