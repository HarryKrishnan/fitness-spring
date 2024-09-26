import 'dart:convert';
import 'package:auth/sighnup.dart';
import 'package:auth/user.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:http/http.dart' as http;

class Login extends StatefulWidget {
  @override
  _LoginState createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final _formKey = GlobalKey<FormState>();
  User user = User("", "");
  final String url = "http://localhost:9000/login";

  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  void initState() {
    super.initState();
    emailController.text = user.email;
    passwordController.text = user.password;
  }

  @override
  void dispose() {
    emailController.dispose();
    passwordController.dispose();
    super.dispose();
  }

  Future save() async {
    var res = await http.post(
      Uri.parse(url),
      headers: {'Content-Type': 'application/json'},
      body: json.encode({'email': user.email, 'password': user.password}),
    );
    print(res.body);
    if (res.statusCode == 200) {
      Navigator.push(
        context,
        MaterialPageRoute(builder: (context) => Dashboard()),
      );
    }
    else {
      // Handle failed login
      showDialog(
        context: context,
        builder: (context) {
          return AlertDialog(
            title: Text('Login Failed'),
            content: Text('Invalid email or password. Please try again.'),
            actions: [
              TextButton(
                onPressed: () => Navigator.of(context).pop(),
                child: Text('OK'),
              ),
            ],
          );
        },
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              Container(
                height: 750,
                width: MediaQuery.of(context).size.width,
                decoration: BoxDecoration(
                  color: Color.fromRGBO(233, 65, 82, 1),
                  boxShadow: [
                    BoxShadow(
                      blurRadius: 10,
                      color: Colors.black,
                      offset: Offset(1, 5),
                    ),
                  ],
                  borderRadius: BorderRadius.only(
                    bottomLeft: Radius.circular(80),
                    bottomRight: Radius.circular(20),
                  ),
                ),
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    children: [
                      SizedBox(height: 100),
                      Text(
                        "Login",
                        style: GoogleFonts.pacifico(
                          fontWeight: FontWeight.bold,
                          fontSize: 50,
                          color: Colors.white,
                        ),
                      ),
                      SizedBox(height: 30),
                      Align(
                        alignment: Alignment.topLeft,
                        child: Text(
                          "Email",
                          style: GoogleFonts.roboto(
                            fontSize: 40,
                            color: Color.fromRGBO(255, 255, 255, 0.8),
                          ),
                        ),
                      ),
                      TextFormField(
                        controller: emailController,
                        onChanged: (val) {
                          user.email = val;
                        },
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return 'Email is Empty';
                          }
                          return null;
                        },
                        style: TextStyle(fontSize: 30, color: Colors.white),
                        decoration: InputDecoration(
                          errorStyle: TextStyle(fontSize: 20, color: Colors.black),
                          border: OutlineInputBorder(borderSide: BorderSide.none),
                        ),
                      ),
                      Container(
                        height: 8,
                        color: Color.fromRGBO(255, 255, 255, 0.4),
                      ),
                      SizedBox(height: 60),
                      Align(
                        alignment: Alignment.topLeft,
                        child: Text(
                          "Password",
                          style: GoogleFonts.roboto(
                            fontSize: 40,
                            color: Color.fromRGBO(255, 255, 255, 0.8),
                          ),
                        ),
                      ),
                      TextFormField(
                        obscureText: true,
                        controller: passwordController,
                        onChanged: (val) {
                          user.password = val;
                        },
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return 'Password is Empty';
                          }
                          return null;
                        },
                        style: TextStyle(fontSize: 30, color: Colors.white),
                        decoration: InputDecoration(
                          errorStyle: TextStyle(fontSize: 20, color: Colors.black),
                          border: OutlineInputBorder(borderSide: BorderSide.none),
                        ),
                      ),
                      Container(
                        height: 8,
                        color: Color.fromRGBO(255, 255, 255, 0.4),
                      ),
                      SizedBox(height: 60),
                      Center(
                        child: InkWell(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => RegisterApp()),
                            );
                          },
                          child: Text(
                            "Don't have an Account?",
                            style: GoogleFonts.roboto(
                              fontWeight: FontWeight.bold,
                              fontSize: 20,
                              color: Colors.white,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              SizedBox(height: 40),
              Container(
                height: 90,
                width: 90,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Color.fromRGBO(233, 65, 82, 1),
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(50),
                    ),
                  ),
                  onPressed: () {
                    if (_formKey.currentState!.validate()) {
                      save();
                    }
                  },
                  child: Icon(
                    Icons.arrow_forward,
                    color: Colors.white,
                    size: 30,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class Dashboard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Text('Welcome to the Dashboard!')),
    );
  }
}

class Register extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Text('Register User')),
    );
  }
}
