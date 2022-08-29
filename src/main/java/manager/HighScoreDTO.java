package manager;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
@Entity
@Table (name = "score_board")
public class HighScoreDTO {
    @Id
    @GeneratedValue
    @Column (name = "id")
    private Long id;
    @Column (name = "high_score")
    private Long highScore;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;


    public Long getHighScore(){
        return highScore;
    }

    public void setHighScore(Long highScore) {
        this.highScore = highScore;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
