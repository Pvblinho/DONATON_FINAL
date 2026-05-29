const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const db = require('../config/db');
const router = express.Router();

// REGISTRO DE USUARIOS

router.post('/register', async (req, res) => {
    const { name, email, password } = req.body || {};
    if (!name || !email || !password)
        return res.status(400).json({ message: 'Faltan campos requeridos' });
    const hash = bcrypt.hashSync(password, 10);
    try{
        db.prepare('INSERT INTO users (name, email, password) VALUES (?, ?, ?)').run(name, email, hash);
        res.status(201).json({ message: 'Usuario registrado exitosamente' });
    } catch (error) {
        res.status(500).json({ message: 'Error al registrar usuario' });
    }
});

// LOGIN DE USUARIOS

router.post('/login', (req, res) => {
    const { email, password } = req.body || {};
    const user = db.prepare('SELECT * FROM users WHERE email = ?').get(email);

    if (!user)
        return res.status(401).json({ message: 'Credenciales inválidas' });
    const valid = bcrypt.compareSync(password, user.password);
    if (!valid)
        return res.status(401).json({ message: 'Credenciales inválidas' });
    const token = jwt.sign(
        { id: user.id, role: user.role },
        process.env.JWT_SECRET,
        { expiresIn: '1h' });
    res.json({ token, message: 'Login exitoso' });
});

// LO


module.exports = router;