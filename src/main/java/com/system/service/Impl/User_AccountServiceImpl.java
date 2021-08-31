package com.system.service.Impl;

import com.system.mapper.User_AccountMapper;
import com.system.pojo.User_Account;
import com.system.service.User_AccountService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_AccountServiceImpl implements User_AccountService {

    @Autowired
   private User_AccountMapper user_accountMapper;
    @Override
    public User_Account selectByIdCard(String idcard) {
        User_Account user_account = user_accountMapper.selectByIdCard(idcard);
        return user_account;
    }

    @Override
    public List<User_Account> selectAll() {
        List<User_Account> list = user_accountMapper.selectAll();
        return list;
    }

    @Override
    public User_Account selectById(Integer id) {
        User_Account user_account = user_accountMapper.selectById(id);
        return user_account;
    }

    @Override
    public Integer insertUser(User_Account user_account) {
        Integer insert = user_accountMapper.insert(user_account);
        return insert;
    }

    @Override
    public Integer deleteUser(Integer id) {
        Integer delete = user_accountMapper.delete(id);
        return delete;
    }

    @Override
    public Integer uptadeUser(User_Account user_account) {
        Integer update = user_accountMapper.update(user_account);
        return update;
    }

    public  List<User_Account> selectByName(String username){
        List<User_Account> user_accounts = user_accountMapper.selectByName(username);
        return user_accounts;
    }

    /**
     * 导出excel
     * @throws Exception
     */
    public Workbook queryExportUser() throws Exception{
        List<User_Account> list = user_accountMapper.selectAll();//读取数据库数据
        String[] excelHeader={"账号ID","姓名","性别","证件号","联系电话","邮箱","密码","创建时间"};  //设置Excel头部
        Workbook wb = new SXSSFWorkbook(1000);

        Sheet sheet = wb.createSheet("Sheet1");//创建工作表
        Row row = sheet.createRow(0);  //创建行，从0开始
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);  //对齐方式

        //导入头部
        for (int i = 0; i < excelHeader.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.setColumnWidth(1, (short) 6000);  //设置列宽
        }
        User_Account user=null;
        //导入数据
        for(int i=0 ; i<list.size();i++){
            row = sheet.createRow(i + 1);
            user=list.get(i);
            row.createCell(0).setCellValue(user.getId());   //设置单元格内容
            row.createCell(1).setCellValue(user.getUsername());
            row.createCell(2).setCellValue(user.getSex());
            row.createCell(3).setCellValue(user.getIdcard());
            row.createCell(4).setCellValue(user.getPhone());
            row.createCell(5).setCellValue(user.getEmail());
            row.createCell(6).setCellValue(user.getPassword());
            row.createCell(7).setCellValue(user.getCreateTime());
        }
        return wb;
    }

}
