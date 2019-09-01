package sgpaeh;

public class GraduationStudent extends Researcher {
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
