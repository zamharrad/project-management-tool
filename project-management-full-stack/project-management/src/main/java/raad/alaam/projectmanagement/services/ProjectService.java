package raad.alaam.projectmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raad.alaam.projectmanagement.domain.Project;
import raad.alaam.projectmanagement.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveAndUpdateProject(Project project){
        return projectRepository.save(project);
    }
}
