# Honest Calculator – Stage 5: Saving memory

---

## 🧠 Description

To complete the project, you need to implement the flowchart below. The old blocks are red-colored. Be careful; some flows can work differently. The functions from the previous stage have not been changed.
![img.png](../resources/images/img_5.png)


---

## 🎯 Objectives

Implement the flowchart. Please, follow the recommendations below:

- Don't use the built-in functions to calculate from a string;
- Copy the messages below. The tests will check if the correct message appears in the correct order. Don't add extra lines or characters.

```text
msg_10 = "Are you sure? It is only one digit! (y / n)"

msg_11 = "Don't be silly! It's just one number! Add to the memory? (y / n)"

msg_12 = "Last chance! Do you really want to embarrass yourself? (y / n)"
```

---

## 📌 Example

The greater-than symbol followed by a space (`>`) represents the user input.

Example 1:

```text
Enter an equation
2 + 3
You are ... lazy
5.0
Do you want to store the result? (y / n):
y
Are you sure? It is only one digit! (y / n)
y
Don't be silly, it's just one number! Add to the memory? (y / n)
n
Do you want to continue calculations? (y / n):
y
Enter an equation
5 + M
You are ... lazy ... very, very lazy
5.0
Do you want to store the result? (y / n):
y
Are you sure? It is only one digit! (y / n)
y
Don't be silly, it's just one number! Add to memory? (y / n)
y
Last chance! Do you really want to embarrass yourself? (y / n)
y
Do you want to continue calculations? (y / n):
y
Enter an equation
M / M
You are ... lazy
1.0
Do you want to store the result? (y / n):
n
Do you want to continue calculations? (y / n):
n
```
