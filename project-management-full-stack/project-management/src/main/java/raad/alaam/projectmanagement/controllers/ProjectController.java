package raad.alaam.projectmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import raad.alaam.projectmanagement.domain.Project;
import raad.alaam.projectmanagement.services.MapValidationErrorService;
import raad.alaam.projectmanagement.services.ProjectService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

       ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationErrorService(result);
       if (errorMap!=null) return errorMap;



        Project project1 = projectService.saveAndUpdateProject(project);
        return new ResponseEntity<Project>(project,HttpStatus.CREATED);
    }
}
