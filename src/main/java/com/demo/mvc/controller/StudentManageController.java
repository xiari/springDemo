package com.demo.mvc.controller;

import com.demo.mvc.model.Dto.SexInfo;
import com.demo.mvc.model.Dto.Student;
import com.demo.mvc.model.StudentEntity;
import com.demo.mvc.service.StudentManageService;
import com.demo.mvc.utils.JsonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XYY78 on 2016/10/9.
 */

@Controller
@RequestMapping("/studentManagement")
public class StudentManageController {

    @Autowired
    private StudentManageService studentManageService;

    @RequestMapping("/init")
    @ResponseBody
    public String init(Model model) {
        List<StudentEntity> list = studentManageService.getStudents();
        model.addAttribute("list", list);
        System.out.println(JsonUtil.toJsonString(list));
        return JsonUtil.toJsonString(list);
    }

    @RequestMapping("/test")
    public List<StudentEntity> test() {
        return studentManageService.getStudents();
    }

    @RequiresPermissions("user:create")
    @RequestMapping("/addStudent")
    public String addStudent(Student student, Model model) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(student.getStudentName());
        studentEntity.setSeqNo(student.getSeqNo());
        studentEntity.setAddress(student.getAddress());
        String sexType= student.getSexType() ;
        System.out.println("sexType: " + sexType);
        studentEntity.setSex(sexType);
        System.out.println("sexType: " + sexType + "_" + studentEntity.getSex());
        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            studentEntity.setBirthday(df.parse(student.getBirthday()));
        }catch (ParseException e) {
            e.printStackTrace();
        }
        studentManageService.addStudent(studentEntity);
        return "studentManageInit";
    }

    // 保存页面
    @RequestMapping(value = "/loadSaveStudent")
    public String loadSaveStudent(Model model) {
        Student student = new Student();
        List<SexInfo> sexInfoList = new ArrayList<>();
        SexInfo sexInfo = new SexInfo() ;
        sexInfo.setSexName("男");
        sexInfo.setSexValue("1");

        SexInfo sexInfo1 = new SexInfo() ;
        sexInfo1.setSexName("女");
        sexInfo1.setSexValue("0");
        sexInfoList.add(sexInfo);
        sexInfoList.add(sexInfo1);

        student.setSexList(sexInfoList);
        model.addAttribute("student", student);
        return "loadSaveStudent";
    }

    // 更新单个实体信息
    @RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST)
    public ModelAndView updateStudent(StudentEntity student) {
        ModelAndView view = new ModelAndView("updateResultView");
        if (studentManageService.updateStudentInfoById(student) > 0) {
            StudentEntity updateResult = studentManageService.getStudentById(student.getId());
            view.addObject("student", updateResult);
            view.addObject("message", "updateSuccessed");
        } else {
            view.addObject("message", "updateFailed");
        }
        return view;
    }

    // 获取单个实体信息
    @RequestMapping("/getStudentById")
    public String getStudentById(@RequestParam Long id, Model model) {
        if (StringUtils.isEmpty(id)) {
            return "studentUpdateView";
        }
        StudentEntity studentEntity = studentManageService.getStudentById(id);
        model.addAttribute("student", studentEntity);
        return "studentUpdateView";
    }

    // 根据id删除
    @RequestMapping("/deleteStudentByIdList")
    @ResponseBody
    public String deleteStudentByIdList(@RequestParam(value = "idList") String idList, Model model) {
        if (StringUtils.isEmpty(idList)) {
            return "studentUpdateView";
        }
        studentManageService.deleteStudentList(idList);
        List<StudentEntity> list = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity();
        list.add(studentEntity);
        studentEntity.setId(1L);
        model.addAttribute("result", "success");
        return JsonUtil.toJsonString(list);
    }
}
