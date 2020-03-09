package raad.alaam.projectmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raad.alaam.projectmanagement.domain.Project;
import raad.alaam.projectmanagement.exceptions.ProjectIdException;
import raad.alaam.projectmanagement.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveAndUpdateProject(Project project){

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }
        catch (Exception ex){
            throw new ProjectIdException("Project ID :"+ project.getProjectIdentifier().toUpperCase()+" already exists");
        }

    }

    public Project findProjectByIdentifer(String projecId){

        Project project =  projectRepository.findByProjectIdentifier(projecId.toUpperCase());

        if (project == null)
        {
            throw new ProjectIdException("Project ID :"+projecId+" ,does not exist");
        }
        return project;
    }

    public Iterable<Project> findAllProject(){
        return projectRepository.findAll();
    }
}
