package movies.spring.data.neo4j.domain.common;

public class LabelClassName {
    private String mySelf = "LabelClassName";
    private Long id;

    public String getMySelf() {
        return mySelf;
    }

    public void setMySelf(String mySelf) {
        this.mySelf = mySelf;
    }

    private String className = "LabelClassName";

    public String getClassName() {
        return "LabelClassName";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
