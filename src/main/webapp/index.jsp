<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Entry Form</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh;">
<div style="background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 100%; max-width: 500px;">
    <h1 style="margin-top: 0; color: #333; text-align: center;">Library Entry Form</h1>
    <form action="submitservlet" method="post" style="display: flex; flex-direction: column;">
        <label for="name" style="margin-bottom: 5px; font-weight: bold; color: #333;">Book Name:</label>
        <input type="text" id="name" name="name" required style="margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px;">

        <label for="author_name" style="margin-bottom: 5px; font-weight: bold; color: #333;">Author Name:</label>
        <input type="text" id="author_name" name="author_name" required style="margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px;">

        <label for="price" style="margin-bottom: 5px; font-weight: bold; color: #333;">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required style="margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px;">

        <label for="publisher" style="margin-bottom: 5px; font-weight: bold; color: #333;">Publisher:</label>
        <input type="text" id="publisher" name="publisher" required style="margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px;">

        <label for="isbn" style="margin-bottom: 5px; font-weight: bold; color: #333;">ISBN:</label>
        <input type="text" id="isbn" name="isbn" required style="margin-bottom: 15px; padding: 10px; font-size: 16px; border: 1px solid #ddd; border-radius: 4px;">

        <div style="display: flex; justify-content: space-between; margin-top: 20px;">
            <button type="submit" style="padding: 10px; font-size: 16px; color: #fff; background-color: #007bff; border: none; border-radius: 4px; cursor: pointer;">Submit</button>
            <a href="viewServlet" style="text-decoration: none;">
                <button type="button" style="padding: 10px; font-size: 16px; color: #fff; background-color: #28a745; border: none; border-radius: 4px; cursor: pointer;">View</button>
            </a>
        </div>
    </form>
</div>
</body>
</html>
