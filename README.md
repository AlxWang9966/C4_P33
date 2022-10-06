# C4_P33_Caesar_Cipher

### Requirements:

  Write an app using two activities: one activity
encrypts with a fixed shift (using a **Caesar
cipher**) a text that the user types in a text field,
and the other activity asks the user to define
the shift, an integer between 1 and 25 (if the
shift value is 3, then the word `the` will be
encrypted into `wkh`. If the word is `zoo`, the
encrypted word is `crr`). Assume that only
lowercase letters from a to z will be used.

### Functions Used and Explanations:

- Layout: For Portrait mode, I used a _relative layout_. For landscape mode, I used a _relative layout_ containing two _linear layouts_ aligned vertically.
- Functions:

calculate the shift
```sh
public static StringBuffer cipher(String input)
```

Pass the saved string to next activity

```sh
Intent intent = new Intent(MainActivity.this, CipherCustom.class);
intent.putExtra("shift_string", input.getText().toString());
startActivity(intent);
```

Get the saved string in the next activity:
```sh
String shift_string = intent.getExtras().getString("shift_string");
```

Maintain the value when rotating screen
```sh
protected void onSaveInstanceState(@NonNull Bundle outState)
protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState)
```

Goes back to the first activity in order to change String
```sh
public void goBack(View view){ this.finish();}
```

