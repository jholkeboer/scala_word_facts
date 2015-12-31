//val sentence = readLine("Enter a sentence: ")
val sentence = "The quick brown fox jumps over the lazy dog."
try {
  if (sentence.length == 0) throw new IllegalArgumentException("Sentence was empty")
} catch {
  case _: IllegalArgumentException => println("Sentence was empty.")
}

val words = sentence.split(" ")
val words_clean = words map { w => w filter (l => l != '.' && l != ',') }
println("Your sentence: " + sentence)

print("Your sentence in reverse: ")
words.reverse map {w => print(w + " ")} ; print('\n')

println("Characters in your sentence: " + sentence.length)

println("Words in your sentence: " + words.length)

val avg_word_len = { var sum = 0; words_clean.map {w => sum = sum + w.length}; sum/words.length }
printf("Average word length: %d" + '\n' + '\n', avg_word_len)

var letters = new scala.collection.mutable.HashMap[Char, Int]
words_clean map { w => w map { l => if (letters.getOrElse(l, 0) == 0) l += (l -> 1) else letters(l) += 1 } }
println("Frequency of each word: ")
