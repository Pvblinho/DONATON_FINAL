const { DataTypes } = require('sequelize');
const sequelize = require('../config/db'); // Tu conexión a la base de datos

const Usuario = sequelize.define('Usuario', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    rut: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true
    },
    nombreCompleto: {
        type: DataTypes.STRING,
        allowNull: false
    },
    email: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false
    },
    tipoUsuarioId: {
        type: DataTypes.INTEGER,
        allowNull: false
    }
}, {
    tableName: 'usuarios',
    timestamps: true
});

module.exports = Usuario;