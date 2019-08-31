package dataobjects;

import java.util.Scanner;

public class Graduationstudent extends Researcher {
    @Override
    public void addResearcher() {
        super.addResearcher();
    }

    @Override
    public boolean isTeacher() {
        return super.isTeacher();
    }

    @Override
    public boolean isMaxProjects() {
        return (this.numberOfProjects() > 1);
    }
}
