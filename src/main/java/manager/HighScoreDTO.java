package manager;


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
    private PlayerDTO playerDTO;


    public Long getHighScore(){
        return highScore;
    }

    public void setHighScore(Long highScore) {
        this.highScore = highScore;
    }

    public void setPlayer(PlayerDTO playerDTO) {
        this.playerDTO = playerDTO;
    }
}
