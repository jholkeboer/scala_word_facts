//val sentence = readLine("Enter a sentence: ")
val sentence = "The quick brown fox jumps over the lazy dog."
val words = sentence.split(" ")
//val words_clean = words map { w => if w.contains(".") }
println("Your sentence: " + sentence)

print("Your sentence in reverse: ")
words.reverse map {w => print(w + " ")} ; print('\n')

println("Characters in your sentence: " + sentence.length)

println("Words in your sentence: " + words.length)

val avg_word_len = { var sum = 0; words.map {w => sum = sum + w.length}; sum/words.length }
printf("Average word length: %d" + '\n', avg_word_len)