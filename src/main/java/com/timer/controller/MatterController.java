package com.timer.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.json.JSONUtil;
import com.timer.controller.form.AddTagForm;
import com.timer.controller.form.AddTaskForm;
import com.timer.controller.form.UpdateStatusForm;
import com.timer.controller.form.UpdateTagNameForm;
import com.timer.service.TaskService;
import com.timer.service.TodoClassifyService;
import com.timer.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MatterController {
    @Autowired
    private TodoClassifyService todoClassifyService;

//    @SaCheckLogin
    @GetMapping("/findTags")
    public Result findUserTags(@RequestParam("userId") Integer id){
        try {
            HashMap data = todoClassifyService.findUserTags(id);
            data.put("tags", JSONUtil.parse(data.get("tags")));
            return Result.success(data);
        }catch ( Exception e){
            return Result.error(500,"请求出错");
        }
    }

    @PostMapping("/addTag")
    public Result addTag(@RequestBody @Valid AddTagForm addTagForm){
        try {
            HashMap params = JSONUtil.parse(addTagForm).toBean(HashMap.class);
            int rows = todoClassifyService.addTag(params);
            System.out.println(rows);
            if(rows >= 2){
                return Result.success("添加成功");
            }else{
                return Result.error(500,"添加失败");
            }
        }catch (Exception e){
            return Result.error(500,"请求出错");
        }
    }

    @PutMapping("/updateTagTitle")
    public Result updateTagName(@RequestBody @Valid UpdateTagNameForm updateTagNameForm){
        try {
            HashMap params = JSONUtil.parse(updateTagNameForm).toBean(HashMap.class);
            int rows = todoClassifyService.updateTagName(params);
            if(rows == 1){
                return Result.success("修改成功");
            }else{
                throw new Exception("修改失败");
            }
        }catch (Exception e){
            return Result.error(500,"请求出错");
        }
    }


    @Autowired
    private TaskService taskService;
    @PostMapping("/addTask")
    public Result addTask (@RequestBody @Valid AddTaskForm addTaskForm){
        try {
            HashMap params = JSONUtil.parse(addTaskForm).toBean(HashMap.class);
            int rows = taskService.addTask(params);
            if(rows == 1){
                return Result.success("添加成功");
            }else{
                return Result.error(500,"添加失败");
            }
        }catch (Exception e){
            return Result.error(500,"请求出错");
        }
    }
    @GetMapping("/findAllTask")
    public Result findUserAllTask (@RequestParam("userId") Integer id){
        try {
            List<HashMap> data = taskService.findUserAllTask(id);
            return Result.success(data);
        }catch ( Exception e){
            System.out.println(e);
            return Result.error(500,"请求出错");
        }
    }

    @PutMapping("/updateStatus")
    public Result updateStatus (@RequestBody @Valid UpdateStatusForm updateStatusForm){
        try {
            HashMap params = JSONUtil.parse(updateStatusForm).toBean(HashMap.class);
            int rows = taskService.updateStatus(params);
            if(rows == 1){
                return Result.success("修改成功");
            }else{
                return Result.error(500,"修改失败");
            }
        }catch (Exception e){
            System.out.println(e);
            return Result.error(500,"请求出错");
        }
    }

    @GetMapping("/findTaskById")
    public Result findTaskById(@RequestParam HashMap params){
        try {
          HashMap task = taskService.findTaskById(params);
            return Result.success(task);
        }catch ( Exception e){
            System.out.println(e);
            return Result.error(500,"请求出错");
        }
    }

}
