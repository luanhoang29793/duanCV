package com.codegym.portfolio.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProject;
    private String nameProject;
    private String summaryProject;
    private String imagesProject;
    private String descriptionProject;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;



    public Project(){}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getSummaryProject() {
        return summaryProject;
    }

    public void setSummaryProject(String summaryProject) {
        this.summaryProject = summaryProject;
    }

    public String getImagesProject() {
        return imagesProject;
    }

    public void setImagesProject(String imagesProject) {
        this.imagesProject = imagesProject;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }
}
