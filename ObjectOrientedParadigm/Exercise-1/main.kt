fun main() {
    // Create document
    var doc = Document("Test Document")

    // Create sheets
    var sheet1 = Sheet("Sheet 1",
        Group(
            Point(1, 2),
            Circle(3, Point(4, 5)),
            Ellipse(6, 7, Point(8, 9)),
        ),
        Rectangle(10, 11, Point(12, 13)),
        Line(Point(14, 15), Point(16, 17)),
        Square(18, Point(19, 20))
    )

    var sheet2 = Sheet("Sheet 2",
        Group(
            Point(21, 22),
            Circle(23, Point(24, 25)),
            Ellipse(26, 27, Point(28, 29)),
        ),
        Rectangle(30, 31, Point(32, 33)),
        Line(Point(34, 35), Point(36, 37)),
        Square(38, Point(39, 40))
    )

    // Add sheets to the document
    doc.addSheet(sheet1)
    doc.addSheet(sheet2)

    // Print the document content
    doc.draw()
}
