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

    public boolean isEmpty(){
        if (this.piece.icon == '\u2003') return true;
        return false;
    }

    public boolean equals(Position end){
        if (this.x != end.x) return false;
        if (this.y != end.y) return false;
        return true;
    }
}
