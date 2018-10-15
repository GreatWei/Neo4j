package movies.spring.data.neo4j.config;

public enum DataSourceType {

    // 从表
    MySql("MySql");

    private String name;

    private DataSourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
