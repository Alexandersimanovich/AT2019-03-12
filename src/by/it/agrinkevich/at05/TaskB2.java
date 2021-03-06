package by.it.agrinkevich.at05;

public class TaskB2 {

    public static void main(String[] args) {
        String poem = new String(Poem.text);
        String[] sentences = poem.replace("...", " ").split("[.?!]+");
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            sentence = sentence.replaceAll("[^а-яА-ЯёЁ]+", " ");
            sentence = sentence.trim();
            sentences[i] = sentence;
        }

        for (int i = 0; i < sentences.length-1; i++) {
            for (int j = i + 1; j < sentences.length; j++) {
                if (sentences[i].length() > sentences[j].length()){
                    String temp = sentences[i];
                    sentences[i] = sentences[j];
                    sentences[j] = temp;
                }
            }
        }
        String result = String.join("\n", sentences);
        System.out.println(result);
    }
}
