import React, { useState } from 'react';
import axios from 'axios';

const CreateAccount = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        mobileNumber: '',
        dob: '',
        gender: '',
        email: '',
        password: '',
        balance: '',
        accountType: '',
        branchId: '',
        maxTransactionAmount: 10000,
        street: '',
        city: '',
        state: '',
        country: '',
        zipCode: '',
        cardNumber: '',
        location: '',
        createdOn: ''
    });

    const [message, setMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({
            ...prev,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const formattedData = {
                ...formData,
                dob: formData.dob, // Assumes input type="date"
                createdOn: formData.createdOn
            };

            const res = await axios.post('http://localhost:8080/accounts', formattedData);
            setMessage(res.data);
        } catch (err) {
            setMessage('Erreur : ' + (err.response?.data || err.message));
        }
    };

    return (
        <div style={{ maxWidth: 600, margin: 'auto' }}>
            <h2>Créer un Compte</h2>
            <form onSubmit={handleSubmit}>
                <input name="firstName" placeholder="Prénom" value={formData.firstName} onChange={handleChange} required />
                <input name="lastName" placeholder="Nom" value={formData.lastName} onChange={handleChange} />
                <input name="mobileNumber" placeholder="Téléphone" value={formData.mobileNumber} onChange={handleChange} required />
                <input name="dob" type="date" value={formData.dob} onChange={handleChange} required />
                <input name="gender" placeholder="Genre" value={formData.gender} onChange={handleChange} required />
                <input name="email" type="email" placeholder="Email" value={formData.email} onChange={handleChange} required />
                <input name="password" type="password" placeholder="Mot de passe" value={formData.password} onChange={handleChange} required />
                <input name="balance" type="number" placeholder="Solde" value={formData.balance} onChange={handleChange} required />
                <input name="accountType" placeholder="Type de compte" value={formData.accountType} onChange={handleChange} required />
                <input name="branchId" type="number" placeholder="ID de l'agence" value={formData.branchId} onChange={handleChange} required />
                <input name="maxTransactionAmount" type="number" placeholder="Montant max" value={formData.maxTransactionAmount} onChange={handleChange} />
                <input name="street" placeholder="Rue" value={formData.street} onChange={handleChange} required />
                <input name="city" placeholder="Ville" value={formData.city} onChange={handleChange} required />
                <input name="state" placeholder="Région" value={formData.state} onChange={handleChange} required />
                <input name="country" placeholder="Pays" value={formData.country} onChange={handleChange} required />
                <input name="zipCode" placeholder="Code postal" value={formData.zipCode} onChange={handleChange} required />
                <input name="cardNumber" placeholder="Numéro de carte" value={formData.cardNumber} onChange={handleChange} required />
                <input name="location" placeholder="Lieu (adresse Aadhar)" value={formData.location} onChange={handleChange} required />
                <input name="createdOn" type="date" value={formData.createdOn} onChange={handleChange} required />

                <button type="submit">Créer</button>
            </form>
            {message && <p>{message}</p>}
        </div>
    );
};

export default CreateAccount;
