package raad.alaam.projectmanagement.exceptions;

public class ProjectIdExceptionResponce {

    private String projectIdentifier;

    public ProjectIdExceptionResponce(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
