package mydomain.model;

import javax.jdo.annotations.*;

@PersistenceCapable(detachable="true")
public class B
{
    @PrimaryKey
    Long id;

    String name;

    public B(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
