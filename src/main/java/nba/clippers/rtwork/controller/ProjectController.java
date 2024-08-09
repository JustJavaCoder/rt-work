package nba.clippers.rtwork.controller;

import nba.clippers.rtwork.db.entity.ProjectInfo;
import nba.clippers.rtwork.service.ProjectService;
import nba.clippers.rtwork.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("projectIndex/")
public class ProjectController {
    /*这里是项目管理页面 的控制器*/

    @Autowired
    ProjectService projectService;


    @GetMapping("indexPic")
    public ResponseEntity<byte[]> getProjectImage() throws IOException {
        Resource resource = new ClassPathResource("static/picture/indexPicture.png");
        byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "image/png");

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }


    @GetMapping("hello")
    public Object sayHello() {

        System.out.println("hello");
        return ResponseUtil.ok("hello,Russell !");
    }

    // @GetMapping("/hello")
    // public ResponseEntity<String> sayHello() {
    //     return ResponseEntity.ok("hello Russell !");
    // }


    /*
     * http://localhost:8080/projectIndex/inproj/findApplPage
     * get 查出来所有的项目信息*/
    @GetMapping("inproj/findApplPage")
    public Object findApplPage() {

        System.out.println("进入了findApplPage方法");

      List<ProjectInfo>  projectInfos= projectService.findApplPage();

        return ResponseUtil.okList(projectInfos);
    }


}
