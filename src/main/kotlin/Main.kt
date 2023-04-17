import org.jsoup.Jsoup

fun getMagnetLinks(url: String): List<String> {
    val doc = Jsoup.connect(url).get()
    val links = mutableListOf<String>()
    val elements = doc.select("a")

    for (element in elements) {
        val href = element.attr("href")
        if (href.startsWith("magnet:?xt", ignoreCase = true)) {
            links.add(href)
        }
    }

    return links
}

fun main(args: Array<String>) {
    val links = getMagnetLinks("https://flixtorrents.com.br/john-wick-de-volta-ao-jogo-2014-torrent-dublado-e-legendado/")
    println(links.joinToString(separator = "\n"))
}