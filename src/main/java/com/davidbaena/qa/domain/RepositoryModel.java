package com.davidbaena.qa.domain;

import java.util.Date;

public class RepositoryModel {

    private String name;
    private String description;
    private boolean isPublic;
    private boolean initialized;

    public RepositoryModel(String name, String description, boolean isPublic, boolean initialize) {
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
        this.initialized = initialize;
    }

    public RepositoryModel(){
        this.name="ANY_REPO"+ new Date().getTime();
        this.description="Lorem Ipsum is simply dummy text of the printing and typesetting industry. ";
        this.isPublic=true;
        this.initialized =true;
    }

    public void makePrivate(){
        isPublic=false;
    }

    public void notInitialized(){
        initialized=false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
