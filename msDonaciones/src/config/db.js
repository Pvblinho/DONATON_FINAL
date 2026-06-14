const Database = require('better-sqlite3');
const path     = require('path');

// Conectar (o crear) la base de datos
const db = new Database(
  path.resolve(process.env.DB_PATH)
);

// Crear tabla si no existe
db.exec(`
  CREATE TABLE IF NOT EXISTS users (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    name      TEXT    NOT NULL,
    email     TEXT    NOT NULL UNIQUE,
    password  TEXT    NOT NULL,
    role      TEXT    DEFAULT 'user',
    createdAt TEXT    DEFAULT CURRENT_TIMESTAMP
  );
  CREATE TABLE IF NOT EXISTS donations (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    userId      INTEGER NOT NULL,
    amount      REAL    NOT NULL,
    message     TEXT,
    createdAt   TEXT    DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(id)
  );
  CREATE TABLE IF NOT EXISTS categories (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    title       TEXT    NOT NULL,
    description TEXT
  );
  CREATE TABLE IF NOT EXISTS type_user (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    name        TEXT    NOT NULL
  );

`);

module.exports = db; // Exportar para usar en otras partes