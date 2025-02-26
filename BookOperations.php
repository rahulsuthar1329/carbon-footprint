class Book {
    private $title;
    private $author;
    private $content;
    private $currentPage = 0;

    public function __construct($title, $author, $content) {
        $this->title = $title;
        $this->author = $author;
        $this->content = $content;
    }

    public function getTitle() {
        return $this->title;
    }

    public function getAuthor() {
        return $this->author;
    }

    public function turnPage() {
        $this->currentPage++;
    }

    public function getCurrentPage() {
        return $this->content[$this->currentPage] ?? "End of book";
    }
}

class LibraryLocation {
    private $shelfNumber;
    private $roomNumber;

    public function __construct($shelf, $room) {
        $this->shelfNumber = $shelf;
        $this->roomNumber = $room;
    }

    public function getLocation() {
        return "Shelf: {$this->shelfNumber}, Room: {$this->roomNumber}";
    }
}

class BookPersistence {
    public function save(Book $book) {
        $filename = "/documents/{$book->getTitle()} - {$book->getAuthor()}.txt";
        file_put_contents($filename, serialize($book));
    }
}

interface Printer {
    public function printPage($page);
}

class PlainTextPrinter implements Printer {
    public function printPage($page) {
        echo $page;
    }
}

class HtmlPrinter implements Printer {
    public function printPage($page) {
        echo "<div style='single-page'>{$page}</div>";
    }
}