package com.techacademy.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.Employee;
import com.techacademy.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
        /** 一覧画面を表示 */
    @GetMapping("/list")
    public String getList(Model model) {
        // 全件検索結果をModelに登録
        model.addAttribute("employeelist", service.getEmployeeList());
        // user/list.htmlに画面遷移
        return "employee/list";
    }
    /**従業員の登録画面を表示 */
    @GetMapping("/register")
    public String getRegister(@ModelAttribute Employee employee) {
        // 登録画面に遷移
        return "employee/register";
    }
    /**従業員の登録処理 */
    @PostMapping("/register")
    public String postRegister(Employee employee) {
        LocalDateTime date = LocalDateTime.now();
        employee.getAuthentication().setEmployee(employee);
        employee.setUpdated_at(date);
        employee.setCreated_at(date);
        employee.setDelete_flag(0);
        service.saveEmployee(employee);
        return "redirect:/employee/list";
    }
    
 // ----- 追加:ここから -----
    /** User更新画面を表示 */
    @GetMapping("/employee/detail/{id}/")
    public String getEmployee(@PathVariable("id") Integer code, Model model) {
        // Modelに登録
        model.addAttribute("employee", service.getEmployee(code));
        // User更新画面に遷移
        return "employee/detail";
    }

    /** User更新処理 */
    @PostMapping("/employee/list/")
    public String postEmployee(Employee employee) {
        // User登録
        service.saveEmployee(employee);
        // 一覧画面にリダイレクト
        return "redirect:/employee/list";
    }
    // ----- 追加:ここまで -----
    
   
}