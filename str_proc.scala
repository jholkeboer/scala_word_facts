import scala.io.Source

//val sentence = readLine("Enter a sentence: ")
val sentence = "Practicing Scala syntax and string processing. The quick brown fox jumps over the lazy dog."
try {
  if (sentence.length == 0) throw new IllegalArgumentException("Sentence was empty")
} catch {
  case _: IllegalArgumentException => println("Sentence was empty.")
}

println("Reading dictionary...")
val dictionary: List[String] = Source.fromFile("dictionary.txt").getLines.toList

val words = sentence.split(" ")
val words_clean = words map { w => w filter (l => l != '.' && l != ',') }
println('\n' + "Your sentence: " + sentence)

print("Your sentence in reverse: ")
words_clean.reverse map {w => print(w + " ")} ; print('\n')

println("Characters in your sentence: " + sentence.length)
println("Words in your sentence: " + words.length)

val avg_word_len = { var sum = 0; words_clean.map {w => sum = sum + w.length}; sum/words.length }
printf("Average word length: %d" + '\n' + '\n', avg_word_len)

var letters = new scala.collection.mutable.HashMap[String, Int]
words_clean map { w => w map { l => val l2 = l.toString.toLowerCase; if (letters.getOrElse(l2, 0) == 0) letters += (l2 -> 1) else letters(l2) += 1 } }
println("Frequency of each letter: ")
for (c <- 'a' to 'z') { val c2 = c.toString; if (letters.getOrElse(c2,0) != 0) println(c2 + ": " + letters(c2)) }

val sorted_words = words_clean map { w =>  w.toLowerCase.sorted }
val anagrams = dictionary filter { w => sorted_words contains w.toLowerCase.sorted }
