package com.system.mapper;

import com.system.pojo.Payment;
import com.system.pojo.User_Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface PaymentMapper {
    @Select("select * from payment")
    /*
    *  private int id;
    private String pay_name;
    private int money;
    private Date outTime;
    private int user_id;
    private String explain;
    private int pay_state;
    private Date createTime;
*/
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "pay_name",property = "pay_name"),
            @Result(column = "money",property = "money"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "explain",property = "explain"),
            @Result(column = "pay_state",property = "pay_state"),
            @Result(column = "createTime",property = "createTime"),
            @Result(column = "user_id",property = "user_account",
                    one = @One(select = "com.system.mapper.PaymentMapper.selectUserById",fetchType = FetchType.EAGER))
    })
    public List<Payment> selectAll();

    @Select("select * from user_account where id=#{user_id}")
    public User_Account selectUserById(Integer user_id);

    @Select("select * from user_account")
    public List<User_Account> selectAllUser_Account();

    @Select("select id from user_account where idcard=#{idcard}")
    public Integer selectByIdCard(String idcard);

    @Insert("insert into payment(pay_name,money,outTime,user_id,`explain`,pay_state,createTime)values(#{pay_name},#{money},#{outTime},#{user_id},#{explain},#{pay_state},#{createTime})")
    public Integer insert(Payment payment);

    @Select("select * from payment where id=#{id}")
    public Payment selectByid(Integer id);

    @Update("update payment set pay_name=#{pay_name},money=#{money},outTime=#{outTime},user_id=#{user_id},`explain`=#{explain},pay_state=#{pay_state},createTime=#{createTime} where id=#{id}")
    public Integer updatePayment(Payment payment);

    @Delete("delete from  payment where id=#{id}")
    public  Integer deletePayment(Integer id);

}
