package com.soft.demo.controller;

import com.soft.demo.model.serverlist;
import com.soft.demo.service.serverListService;
import com.soft.demo.web.Dto.ServerDto;
import com.soft.demo.web.VM.BasicResultVM;
import com.soft.demo.web.exceptions.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serverList")
@Slf4j
public class serverListController {

    @Autowired
    private serverListService serverListService;
    


    @Value("${spring.application.name}")
    private String name;
    @Value("${server.port}")
    private String port;
    @Value("${eureka.instance.hostname}")
    private String url;

    @GetMapping(value = "/find")
    public BasicResultVM find(Integer id){
        BasicResultVM basicResultVM = new BasicResultVM();
        serverlist serverlist = serverListService.find(id);
        if(serverlist == null){
            basicResultVM.setReturnCode(200);
            basicResultVM.setReturnDesc("暂无数据");
            basicResultVM.setReturnResult(serverlist);
        }else {
            basicResultVM.setReturnCode(200);
            basicResultVM.setReturnDesc("查询成功");
            basicResultVM.setReturnResult(serverlist);
        }
        return basicResultVM;
    }

    /**
     * 新增或更新
     * @param dto
     * @return
     */
    @PostMapping(value = "/insertServer")
    public BasicResultVM insertServer(ServerDto dto){
        BasicResultVM basicResultVM = new BasicResultVM();
        serverListService.insert(dto);
        basicResultVM.setReturnCode(200);
        basicResultVM.setReturnDesc("操作成功");
        basicResultVM.setReturnResult(null);
        return basicResultVM;
    }

    /**
     * 根据Id删除
     * @param id
     * @return
     */
    @PostMapping(value = "/delete")
    public BasicResultVM deldte(Integer id){
        BasicResultVM basicResultVM = new BasicResultVM();
        if (id == null) {
            throw new ParamException();
        }else{
            serverListService.delete(id);
            basicResultVM.setReturnCode(200);
            basicResultVM.setReturnDesc("删除成功！");
            basicResultVM.setReturnResult(null);
        }
        return basicResultVM;
    }

    @GetMapping(value = "/getInfo")
    public void getInfo(){
        log.info("\n----------------------------------------------------------\n\t" +
                "Application \t" + name+ " \tis running! Access URLs:\n\t" +
                "Local: \t\t http ://localhost:" + port + "\n\t" +
                "External: \t http ://" + url + ":" + port + "\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------");
    }
}
