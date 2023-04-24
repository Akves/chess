import javax.lang.model.type.NullType;

public class Position {
    int x;
    int y;

    PiecesAbstract piece;

    Position(int x, int y, PiecesAbstract type){
        this.x = x;
        this.y = y;
        piece = type;
    }
    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
