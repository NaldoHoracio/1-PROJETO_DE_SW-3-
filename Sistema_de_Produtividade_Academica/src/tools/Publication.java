package tools;

import dataobjects.Researcher;
import dataobjects.Teacher;

import java.util.ArrayList;

public class Publication {
    private String titleConference;
    private String conference;
    private int yearPublicationConference;
    private String associatedProject;
    private ArrayList<Researcher> authors = new ArrayList<Researcher>();
    private Teacher leader;

    public String getTitle() {
        return this.titleConference;
    }

    public void setTitleConference(String titleConferenceIn) {
        this.titleConference = titleConferenceIn;
    }

    public String getConference() {
        return this.conference;
    }

    public void setConference(String conferenceIn) {
        this.conference = conferenceIn;
    }

    public int getYearPublicationConference() {
        return this.yearPublicationConference;
    }

    public void setYearPublicationConference(int yearPublicationConferenceIn) {
        this.yearPublicationConference = yearPublicationConferenceIn;
    }

    public String getAssociatedProject() {
        return this.associatedProject;
    }

    public void setAssociatedProject(String associatedProjectIn) {
        this.associatedProject = associatedProjectIn;
    }

    public void setLeader(Teacher leaderIn) {
        this.leader = leaderIn;
    }

    public Teacher getLeader() {
        return this.leader;
    }

    public void addAuthors(Researcher authorsIn) {
        this.authors.add(authorsIn);
    }

    public boolean isAssociatedAuthor(Researcher researcherIn) {
        return this.authors.contains(researcherIn);
    }

    @Override
    public int compareTo(Publication publicacao) {
        if (this.yearPublicationConference > publicacao.yearPublicationConference) return -1;
        else if (this.yearPublicationConference < publicacao.yearPublicationConference) return 1;
        else return 0;
    }
}
