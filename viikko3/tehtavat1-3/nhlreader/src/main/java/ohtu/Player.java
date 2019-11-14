
package ohtu;

import lombok.Data;

import java.util.Date;

@Data
public class Player {

    private String name;
    private String team;
    private String nationality;
    private Date birthdate;
    private Integer goals;
    private Integer assists;
    private Integer penalties;

    @Override
    public String toString() {
        return String.format("%-25s %-4s  %-2s+ %-2s = %-2s", name, team, goals, assists, (goals+assists));
    }
}
