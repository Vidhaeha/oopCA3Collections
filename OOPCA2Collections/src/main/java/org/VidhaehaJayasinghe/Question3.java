package main.java.org.VidhaehaJayasinghe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Name:
 * Class Group:
 */
public class Question3 {   // Nested HTML (Stack)

    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for (String fName : files) {
            System.out.print(fName + ": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
        }
    }

    public static boolean validate(String filename) throws FileNotFoundException {
        Stack<String> stack = new Stack<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        String[] selfClosingTags = {"<br>"};

        while (scanner.hasNext()) {
            String tag = scanner.next();

            if (isSelfClosingTag(tag, selfClosingTags)) {
                // Ignore self-closing tags
                continue;
            }

            if (isOpeningTag(tag)) {
                // Push opening tags onto the stack
                stack.push(tag);
            } else if (isClosingTag(tag)) {
                // Check if the stack is empty or tags are mismatched
                if (stack.isEmpty() || !tagsMatch(stack.pop(), tag)) {
                    scanner.close();
                    return false;
                }
            }
        }

        scanner.close();
        return stack.isEmpty();
    }

    private static boolean isSelfClosingTag(String tag, String[] selfClosingTags) {
        for (String selfClosing : selfClosingTags) {
            if (tag.equals(selfClosing)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOpeningTag(String tag) {
        return tag.matches("<[^/].*?>"); // Matches tags
    }

    private static boolean isClosingTag(String tag) {
        return tag.matches("</.*?>");
    }

    private static boolean tagsMatch(String opening, String closing) {
        return closing.equals(opening.replace("<", "</"));
    }


}
