package raad.alaam.projectmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raad.alaam.projectmanagement.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {


    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);

}
