package sgpaeh;

import java.util.ArrayList;

public class Publication implements Comparable<Publication>
{
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

    public void setAssociatedProject(String associatedProjectIn) {
        this.associatedProject = associatedProjectIn;
    }

    public void addAuthors(Researcher authorsIn) {
        this.authors.add(authorsIn);
    }

    public boolean isAssociatedAuthor(Researcher researcherIn) {
        return this.authors.contains(researcherIn);
    }

    @Override
    public int compareTo(Publication publication) {
        if (this.yearPublicationConference > publication.yearPublicationConference) return -1;
        else if (this.yearPublicationConference < publication.yearPublicationConference) return 1;
        else return 0;
    }
}

