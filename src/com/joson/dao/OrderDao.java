package com.joson.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import com.joson.domain.Orders;

/*
 * 订单dao接口类
 */
@Repository
public interface OrderDao {
	@Results(id ="orderMap",value = {
			@Result(id = true,column="order_id",property = "orderId"),
			@Result(column="order_totalmoney",property = "orderTotalMoney"),
			@Result(column="order_time",property = "orderTime"),
			@Result(column="order_status",property = "orderStatus"),
			@Result(column="order_detail",property = "orderDetail"),
	})
	
	/*
	 * 查询全部订单
	 */
	@Select("select * from item_order")
	List<Orders> findAllOrder();
	
	
	/*
	 * 添加一个订单到订单表
	 */
	@Insert("insert into item_order(order_id,order_totalmoney,order_time,order_status,order_detail)"
			+ "values(#{orderId},#{orderTotalMoney},#{orderTime},#{orderStatus},#{orderDetail})")
	@ResultMap("orderMap")
	void addOrder(Orders order);
	
	
	/*
	 * 根据订单id查询订单信息
	 */
	@ResultMap("orderMap")
	@Select("select * from item_order where order_id = #{orderId}")
	Orders findById(Integer oid);
	
	/*
	 *	订单中商品修改时，订单信息修改（金额 商品）
	 */
	@ResultMap("orderMap")
	@Update("update item_order set order_totalmoney = #{orderTotalMoney} where order_id=#{orderId}")
	void updateProduct(Orders order);
	

	/*
	 * 根据订单id删除订单
	 */
	@ResultMap("orderMap")
	@Update("delete from item_order where order_id=#{orderId}")
	void deleteOrder(Integer oId);

}
