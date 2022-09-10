# Java banking school project

## Introduction

Small college object-oriented programing Java project.

In this project I explored using: Generic collections, singleton patterns, observer patterns, inheritance, etc.


## Check out the code

1. Clone the repository in a new folder.

```sh
git clone https://github.com/GabrielWaif/Java_Bank.git
```

2. Extract the zip file

3. Open the extracted folder with your IDE of preference that runs Java.

## Explanations

The program is divided into 4 Tabs:

1. Admin

Here you will have access to global info about all the accounts that were created in the program, such as seeing the total money available in all the accounts and seeing the transition history.

PS: the default admin password is admin

2. Sign up

Here you will be able to open a user account, providing and name and a password, and a unique Id will be generated for that account, write that down because you will need it to log in.

3. Sign in

Using your new account you can sign in using the Id that you were given and the password used to create the account.

Similar to the admin tab here you will have access to the balance, and transition history and most importantly you will be able to make a transition to other accounts using their id.

4. Deposit

Here you can make deposits to an account without an account, using an identifier name and the id of the receptor.