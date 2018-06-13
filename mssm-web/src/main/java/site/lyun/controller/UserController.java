package site.lyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import site.lyun.pojo.Item;
import site.lyun.pojo.User;
import site.lyun.pojo.UserVo;
import site.lyun.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/file.action",method = {RequestMethod.POST})
    public void fileReceiver(MultipartFile file,HttpServletResponse response) throws IOException {

        response.getWriter().write("Size:"+ file.getSize());
    }
    @RequestMapping(value ="/find.action")
    public ModelAndView findAll(User user, String content, Date date){
        System.out.print(content);
        System.out.print(user);
        ModelAndView mav = new ModelAndView();
        mav.addObject("date",date);
        mav.addObject("list",userService.findAll());
        mav.setViewName("/end.jsp");
        return mav;
    }

    @RequestMapping(value = "/list.action")
    public void listTest(Integer[] ids, HttpServletResponse response, Model model){
        for (Integer id: ids
             ) {
            System.out.print(id.toString());
        }
        try {
            response.getWriter().write("hhhhhhhhhhhhhhh");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*return null;*/
    }
    @RequestMapping(value = "/userTest.action")
    public void listTest(UserVo vo, HttpServletResponse response, Model model) throws IOException {
        for (User user: vo.getUserList()
                ) {
            System.out.println(user.toString());
        }
        response.getWriter().write("hhhhhhhhhhhhhhh");

        /*return null;*/
    }
    @RequestMapping(value = "/error.action")
    public String errorTest(){
        int i = 1/0;
        return "end.jsp";
    }
    @RequestMapping(value="/ajaxTest.action")
    public void ajaxJsonTest(@RequestBody Item item, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write("Welcome");
        System.out.println(item);
       /* writer.write(item.toString());*/
    }
    @RequestMapping(value="/ajaxJsonParamTest.action")
    public @ResponseBody Item ajaxJsonParamTest(@RequestBody Item item, HttpServletResponse response) throws IOException {
        /*PrintWriter writer = response.getWriter();
        writer.write("Welcome");*/
        System.out.println(item);
        return item;
       /* writer.write(item.toString());*/
    }
}
