import React, { useState } from 'react'

import { Navbar, Nav, NavbarToggler, Collapse, NavItem, NavLink } from 'reactstrap';
import { NavLink as Link } from 'react-router-dom';

function Header() {
    const [menuOpen, setMenuOpen] = useState(false);
    const toggleMenu = () => setMenuOpen(!menuOpen);

    return (
        <div>
             <Navbar dark expand="sm" fixed="top" className="bg-dark">
                <NavbarToggler aria-label="Menu" onClick={toggleMenu} />

                <Collapse isOpen={menuOpen} navbar>
                    <Nav id="header-tabs" className="ml-auto" navbar>
                    <NavItem>
                        <NavLink tag={Link} to="/config" className="d-flex align-items-center">
                        <span>Configurations</span>
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/user-infos" className="d-flex align-items-center">
                        <span>User</span>
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/mosques" className="d-flex align-items-center">
                        <span>Mosques & Sessions</span>
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/background" className="d-flex align-items-center">
                        <span>Background Process</span>
                        </NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/logs" className="d-flex align-items-center">
                        <span>Logs</span>
                        </NavLink>
                    </NavItem>
                    </Nav>
                </Collapse>

             </Navbar>
            
        </div>
    )
}

export default Header
