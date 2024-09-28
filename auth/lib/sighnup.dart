import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'login.dart';

class RegisterApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Register Form',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        textTheme: TextTheme(
          bodyText2: TextStyle(color: Colors.grey[800]),
        ),
        inputDecorationTheme: InputDecorationTheme(
          filled: true,
          fillColor: Colors.grey[100],
          contentPadding: EdgeInsets.symmetric(vertical: 12.0, horizontal: 16.0),
          border: OutlineInputBorder(
            borderRadius: BorderRadius.circular(8.0),
            borderSide: BorderSide.none,
          ),
          focusedBorder: OutlineInputBorder(
            borderRadius: BorderRadius.circular(8.0),
            borderSide: BorderSide(color: Colors.blue, width: 2.0),
          ),
          labelStyle: TextStyle(fontSize: 16.0, color: Colors.grey[800]),
        ),
      ),
      home: RegisterScreen(),
    );
  }
}

class RegisterScreen extends StatefulWidget {
  @override
  _RegisterScreenState createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {
  final _formKey = GlobalKey<FormState>();

  // Form field controllers
  final TextEditingController nameController = TextEditingController();
  final TextEditingController ageController = TextEditingController();
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController heightController = TextEditingController();
  final TextEditingController weightController = TextEditingController();
  final TextEditingController bmiController = TextEditingController();
  final TextEditingController caloriesController = TextEditingController();
  final TextEditingController activityController = TextEditingController();
  final TextEditingController waterIntakeTargetController = TextEditingController();
  final TextEditingController waterConsumedController = TextEditingController();

  String picture = '';

  @override
  void dispose() {
    nameController.dispose();
    ageController.dispose();
    emailController.dispose();
    passwordController.dispose();
    heightController.dispose();
    weightController.dispose();
    bmiController.dispose();
    caloriesController.dispose();
    activityController.dispose();
    waterIntakeTargetController.dispose();
    waterConsumedController.dispose();
    super.dispose();
  }

  // Function to pick a picture (for simplicity, just setting a mock string)
  void _pickPicture() {
    setState(() {
      picture = 'Picture Selected';
    });
  }

  // Function to submit form data to the REST API
  Future<void> _submitData() async {
    final String url = 'http://localhost:8080/register';  // Replace with your API URL

    // Collecting form data
    Map<String, dynamic> formData = {
      'name': nameController.text,
      'age': int.tryParse(ageController.text),
      'email': emailController.text,
      'password': passwordController.text,  // Password field
      'height': double.tryParse(heightController.text),
      'weight': double.tryParse(weightController.text),
      'bmi': double.tryParse(bmiController.text),
      'calories': int.tryParse(caloriesController.text),
      'activity': activityController.text,
      'picture': picture,
      'waterintaketarget': double.tryParse(waterIntakeTargetController.text),
      'waterconsumed': double.tryParse(waterConsumedController.text),
    };

    try {
      final response = await http.post(
        Uri.parse(url),
        headers: {
          'Content-Type': 'application/json',
        },
        body: jsonEncode(formData),
      );

      if (response.statusCode == 200) {
        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => Login()),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Failed to submit data')),
        );
      }
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error: $e')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Register'),
      ),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: ListView(
            children: [
              // Name
              TextFormField(
                controller: nameController,
                decoration: InputDecoration(labelText: 'Name'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your name';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Age
              TextFormField(
                controller: ageController,
                decoration: InputDecoration(labelText: 'Age'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your age';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Email
              TextFormField(
                controller: emailController,
                decoration: InputDecoration(labelText: 'Email'),
                keyboardType: TextInputType.emailAddress,
                validator: (value) {
                  if (value == null || value.isEmpty || !value.contains('@')) {
                    return 'Please enter a valid email';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Password
              TextFormField(
                controller: passwordController,
                decoration: InputDecoration(labelText: 'Password'),
                obscureText: true,  // Hides password input
                validator: (value) {
                  if (value == null || value.isEmpty || value.length < 6) {
                    return 'Password must be at least 6 characters long';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Height
              TextFormField(
                controller: heightController,
                decoration: InputDecoration(labelText: 'Height (cm)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your height';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Weight
              TextFormField(
                controller: weightController,
                decoration: InputDecoration(labelText: 'Weight (kg)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your weight';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // BMI
              TextFormField(
                controller: bmiController,
                decoration: InputDecoration(labelText: 'BMI'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your BMI';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Calories
              TextFormField(
                controller: caloriesController,
                decoration: InputDecoration(labelText: 'Calories (per day)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your daily calorie intake';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Activity
              TextFormField(
                controller: activityController,
                decoration: InputDecoration(labelText: 'Activity Level'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please describe your activity level';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Picture
              ListTile(
                title: Text(picture.isEmpty ? 'No picture selected' : picture),
                trailing: IconButton(
                  icon: Icon(Icons.camera_alt),
                  onPressed: _pickPicture,
                ),
              ),
              SizedBox(height: 16),
              // Water Intake Target
              TextFormField(
                controller: waterIntakeTargetController,
                decoration: InputDecoration(labelText: 'Water Intake Target (ml)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your water intake target';
                  }
                  return null;
                },
              ),
              SizedBox(height: 16),
              // Water Consumed
              TextFormField(
                controller: waterConsumedController,
                decoration: InputDecoration(labelText: 'Water Consumed (ml)'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Please enter your water consumption';
                  }
                  return null;
                },
              ),
              SizedBox(height: 32),
              // Submit Button
              ElevatedButton(
                style: ElevatedButton.styleFrom(
                  padding: EdgeInsets.symmetric(vertical: 16),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(12),
                  ),
                ),
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    // Process form data
                    _submitData();
                  }
                },
                child: Text('Submit', style: TextStyle(fontSize: 18)),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
