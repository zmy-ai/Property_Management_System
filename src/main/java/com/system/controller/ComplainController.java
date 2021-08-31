package com.system.controller;

import com.system.pojo.Complain;
import com.system.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ComplainController {
    @Autowired
    private ComplainService complainService;

    @RequestMapping("/Complaintshow.do")
    public ModelAndView showComplaint(){
        List<Complain> complains = complainService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",complains);
        modelAndView.setViewName("Complain.jsp");
        return modelAndView;
    }

    @RequestMapping("/upCompain.do")
    public ModelAndView upCompain(Integer id){
        Integer integer = complainService.updateState(id);
        return showComplaint();
    }
}
