package com.system.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.pojo.Maintain;
import com.system.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MaintainController {
    @Autowired
     private MaintainService  maintainService;

    @RequestMapping("/showMaintain.do")
    public ModelAndView showMaintain(){
        List<Maintain> maintains = maintainService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", maintains);
        modelAndView.setViewName("Maintain.jsp");
        return  modelAndView;
    }
    @RequestMapping("/updateMaintain.do")
    public ModelAndView updateMaintain(Integer id){
        Integer integer = maintainService.update_PropertyState(id);
        return showMaintain();
    }
}
