const express = require('express');
const db = require('../config/db');
const verifyToken = require('../middleware/auth');
const router = express.Router();

router.use(verifyToken);

// get /users listar todos
router.get('/', (req, res) => {
    const users = db.prepare('SELECT id, name, email, role, created_at FROM users').all();
    res.json(users);
});

//get /users/:id obtener un usuario por id

router.get('/:id', (req, res) => {
    const user = db.prepare('SELECT id, name, email, role, created_at FROM users WHERE id = ?').get(req.params.id);

    if (!user) return res.status(404).json({ message: 'Usuario no encontrado' });
    res.json(user);
});

//put /users/:id actualizar un usuario por id

router.put('/:id', (req, res) => {
    const { name, email} = req.body;
    const { changes } = db.prepare(
        'UPDATE users SET name = ?, email = ? WHERE id = ?'
    ).run(name, email, req.params.id);

    if (changes === 0)
        return res.status(404).json({ message: 'Usuario no encontrado' });
    res.json({ message: 'Usuario actualizado exitosamente' });
});

//delete /users/:id eliminar un usuario por id

router.delete('/:id', (req, res) => {
    const { changes } = db.prepare(
        'DELETE FROM users WHERE id = ?'
    ).run(req.params.id);

    if (changes === 0)
        return res.status(404).json({ message: 'Usuario no encontrado' });
    res.json({ message: 'Usuario eliminado exitosamente' });
});

module.exports = router;