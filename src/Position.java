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
        return this.piece.icon == '\u2003';
    }

    public boolean equals(Position end){
        if (this.x != end.x) return false;
        return this.y == end.y;
    }
}
