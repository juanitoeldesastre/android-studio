# app.py
from config import app, db
import routes  # Importamos las rutas

if __name__ == "__main__":
    with app.app_context():
        db.create_all()  # Crear la base de datos si no existe
    app.run(debug=True)
