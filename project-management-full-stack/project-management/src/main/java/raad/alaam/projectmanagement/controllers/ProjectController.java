package raad.alaam.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raad.alaam.projectmanagement.domain.Project;
import raad.alaam.projectmanagement.services.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project){

        Project project1 = projectService.saveAndUpdateProject(project);
        return new ResponseEntity<Project>(project,HttpStatus.CREATED);
    }
}
